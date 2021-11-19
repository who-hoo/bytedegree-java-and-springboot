package springbootstudy.service;

import java.util.Optional;
import org.springframework.stereotype.Service;
import springbootstudy.model.entity.Partner;
import springbootstudy.model.network.Header;
import springbootstudy.model.network.request.PartnerApiRequest;
import springbootstudy.model.network.response.PartnerApiResponse;

@Service
public class PartnerApiLogicService
    extends BaseService<PartnerApiRequest, PartnerApiResponse, Partner> {

    @Override
    public Header<PartnerApiResponse> create(Header<PartnerApiRequest> request) {
        return null;
    }

    @Override
    public Header<PartnerApiResponse> read(Long id) {
        Optional<Partner> selectedPartner = baseRepository.findById(id);
        return selectedPartner
            .map(partner -> response(partner))
            .orElseGet(() -> Header.ERROR("no data"));
    }

    @Override
    public Header<PartnerApiResponse> update(Header<PartnerApiRequest> request) {
        return null;
    }

    @Override
    public Header<PartnerApiResponse> delete(Long id) {
        return null;
    }

    private Header<PartnerApiResponse> response(Partner partner) {
        PartnerApiResponse partnerApiResponse = PartnerApiResponse.builder()
            .id(partner.getId())
            .name(partner.getName())
            .status(partner.getStatus())
            .address(partner.getAddress())
            .callCenter(partner.getCallCenter())
            .partnerNumber(partner.getPartnerNumber())
            .ceoName(partner.getCeoName())
            .registeredAt(partner.getRegisteredAt())
            .unregisteredAt(partner.getUnregisteredAt())
            .build();
        return Header.OK(partnerApiResponse);
    }
}
