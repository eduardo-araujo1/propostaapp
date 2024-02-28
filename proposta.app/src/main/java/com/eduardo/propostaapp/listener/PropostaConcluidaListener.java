package com.eduardo.propostaapp.listener;

import com.eduardo.propostaapp.entity.Proposta;
import com.eduardo.propostaapp.service.WebSocketService;
import com.eduardo.propostaapp.dto.PropostaResponseDto;
import com.eduardo.propostaapp.mapper.PropostaMapper;
import com.eduardo.propostaapp.repository.PropostaRepository;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class PropostaConcluidaListener {

    private PropostaRepository propostaRepository;

    private WebSocketService webSocketService;

    @RabbitListener(queues = "${rabbitmq.queue.proposta.concluida}")
    public void propostaConcluida(Proposta proposta) {
        propostaRepository.save(proposta);
        PropostaResponseDto responseDto = PropostaMapper.INSTANCE.convertEntityToDto(proposta);
        webSocketService.notificar(responseDto);
    }
}