package com.example.app.Service;

import com.example.app.Models.Merchant;
import com.example.app.Repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchantServiceImp implements MerchantService{
    private final MerchantRepository merchantRepository;

    @Autowired
    public MerchantServiceImp(MerchantRepository merchantRepository) {
        this.merchantRepository = merchantRepository;
    }

    @Override
    public Merchant createMerchant(Merchant merchant) {
        return merchantRepository.save(merchant);
    }

    @Override
    public Merchant updateMerchant(Long merchantId, Merchant updatedMerchant) {
        Merchant existingMerchant = getMerchantById(merchantId);
        existingMerchant.setMerchantNumber(updatedMerchant.getMerchantNumber());
        existingMerchant.setMerchantName(updatedMerchant.getMerchantName());
        existingMerchant.setStatusMerchant(updatedMerchant.getStatusMerchant());
        existingMerchant.setStatusDate(updatedMerchant.getStatusDate());
        existingMerchant.setStatusReason(updatedMerchant.getStatusReason());
        existingMerchant.setMerchantMcc(updatedMerchant.getMerchantMcc());
        existingMerchant.setMerchantManageCode(updatedMerchant.getMerchantManageCode());
        existingMerchant.setMerchantCommissionCode(updatedMerchant.getMerchantCommissionCode());
        existingMerchant.setTypeTransactionSupported(updatedMerchant.getTypeTransactionSupported());
        existingMerchant.setFormerCommission(updatedMerchant.getFormerCommission());
        existingMerchant.setDateEffectiveCommission(updatedMerchant.getDateEffectiveCommission());
        existingMerchant.setContactName(updatedMerchant.getContactName());
        existingMerchant.setLegalId(updatedMerchant.getLegalId());
        existingMerchant.setMotherTongue(updatedMerchant.getMotherTongue());
        existingMerchant.setAddress1(updatedMerchant.getAddress1());
        existingMerchant.setTypeAddress1(updatedMerchant.getTypeAddress1());
        existingMerchant.setCityCode1(updatedMerchant.getCityCode1());
        existingMerchant.setCountryCode1(updatedMerchant.getCountryCode1());
        existingMerchant.setAddress2(updatedMerchant.getAddress2());
        existingMerchant.setTypeAddress2(updatedMerchant.getTypeAddress2());
        existingMerchant.setCityCode2(updatedMerchant.getCityCode2());
        existingMerchant.setCountryCode2(updatedMerchant.getCountryCode2());
        existingMerchant.setAddress3(updatedMerchant.getAddress3());
        existingMerchant.setTypeAddress3(updatedMerchant.getTypeAddress3());
        existingMerchant.setCityCode3(updatedMerchant.getCityCode3());
        existingMerchant.setCountryCode3(updatedMerchant.getCountryCode3());
        existingMerchant.setMobileNumber(updatedMerchant.getMobileNumber());
        existingMerchant.setWorkPhoneNumber(updatedMerchant.getWorkPhoneNumber());
        existingMerchant.setHomePhoneNumber(updatedMerchant.getHomePhoneNumber());
        existingMerchant.setRecordOrigine(updatedMerchant.getRecordOrigine());
        existingMerchant.setLastActionCode(updatedMerchant.getLastActionCode());
        existingMerchant.setLastActionDate(updatedMerchant.getLastActionDate());
        existingMerchant.setLastActionUser(updatedMerchant.getLastActionUser());
        existingMerchant.setMerchantAccounts(updatedMerchant.getMerchantAccounts());
        existingMerchant.setSupplementaryData1(updatedMerchant.getSupplementaryData1());
        existingMerchant.setSupplementaryData2(updatedMerchant.getSupplementaryData2());
        existingMerchant.setUserCapturing(updatedMerchant.getUserCapturing());
        existingMerchant.setDurPreAuth(updatedMerchant.getDurPreAuth());
        existingMerchant.setNetworkAccepted(updatedMerchant.getNetworkAccepted());
        existingMerchant.setEmailAddress(updatedMerchant.getEmailAddress());
        existingMerchant.setWebsite(updatedMerchant.getWebsite());
        existingMerchant.setLandMark(updatedMerchant.getLandMark());
        existingMerchant.setRegisteredLocation(updatedMerchant.getRegisteredLocation());

        return merchantRepository.save(existingMerchant);
    }

    @Override
    public void deleteMerchant(Long merchantId) {
        merchantRepository.deleteById(merchantId);
    }

    @Override
    public Merchant getMerchantById(Long merchantId) {
        return merchantRepository.findById(merchantId)
                .orElseThrow(() -> new IllegalArgumentException("Merchant not found with ID: " + merchantId));
    }

    @Override
    public List<Merchant> getAllMerchants() {
        return merchantRepository.findAll();
    }
}
