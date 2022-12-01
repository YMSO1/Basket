package com.example.demo.mapper;

import com.example.demo.dto.InvoiceDto;
import com.example.demo.model.Invoice;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author YMS01
 * @date 30.11.2022 14:18
 */
@Mapper
public interface InvoiceMapper {
    InvoiceMapper INSTANCE = Mappers.getMapper(InvoiceMapper.class);

    List<InvoiceDto> toDtoList(List<Invoice> invoices);

    Invoice invoiceDtoToInvoice(InvoiceDto invoiceDto);

    InvoiceDto invoiceToInvoiceDto(Invoice invoice);
}
