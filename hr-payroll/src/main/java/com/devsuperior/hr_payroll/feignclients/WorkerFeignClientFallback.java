package com.devsuperior.hr_payroll.feignclients;

import com.devsuperior.hr_payroll.entities.Worker;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class WorkerFeignClientFallback implements WorkerFeignClient {
    @Override
    public ResponseEntity<Worker> findById(Long id) {
        throw new WorkerServiceUnavailableException("hr-worker indisponível");
    }
}
