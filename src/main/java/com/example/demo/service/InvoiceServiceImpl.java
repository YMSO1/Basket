package com.example.demo.service;

import com.example.demo.dto.InvoiceDto;
import com.example.demo.mapper.InvoiceMapper;
import com.example.demo.model.Invoice;
import com.example.demo.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author YMS01
 * @date 30.11.2022 14:30
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class InvoiceServiceImpl implements InvoiceService {
    private final InvoiceRepository repository;

    @Override
    public List<InvoiceDto> findAll() {
        log.info("All Invoices was found");
        return InvoiceMapper.INSTANCE.toDtoList(repository.findAllNotRemoved());
    }

    @Override
    public InvoiceDto findById(Long id) {

        log.info("Invoice with id = {} was found", id);
        return InvoiceMapper.INSTANCE.invoiceToInvoiceDto(repository.findInvoiceByIdIfNotRemoved(id));
    }

    @Override
    @Transactional
    public void save(InvoiceDto invoiceDto) {
        Invoice invoice = InvoiceMapper.INSTANCE.invoiceDtoToInvoice(invoiceDto);

        invoice.setIsRemoved(false);
        repository.save(invoice);
        log.info("Invoice was saved: {}", invoice);
    }

    @Override
    @Transactional
    public void update(Long id, InvoiceDto invoiceDto) {
        Invoice fromDto = InvoiceMapper.INSTANCE.invoiceDtoToInvoice(invoiceDto);
        Invoice newInvoice = repository.findInvoiceByIdIfNotRemoved(id);

        newInvoice.setNumber(fromDto.getNumber());
        newInvoice.setIsRemoved(false);
        repository.save(newInvoice);
        log.info("Invoice was updated: {}", newInvoice);

    }

    @Override
    @Transactional
    public void deleteById(Long id) {

        repository.markInvoiceAsRemoved(id);
        log.info("Invoice with id = {} was marked as removed", id);
    }
}
