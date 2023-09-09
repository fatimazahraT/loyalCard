package com.example.app.Service;

import com.example.app.Models.Conversion;
import com.example.app.Repository.ConversionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConversionServiceImp implements ConversionService{
    private final ConversionRepository conversionRepository;

    public ConversionServiceImp(ConversionRepository conversionRepository) {
        this.conversionRepository = conversionRepository;
    }

    @Override
    public Conversion createConversion(Conversion conversion) {
        return conversionRepository.save(conversion);
    }

    @Override
    public Conversion updateConversion(Long conversionId, Conversion updatedConversion) {
        Optional<Conversion> existingConversionOptional = conversionRepository.findById(conversionId);
        if (existingConversionOptional.isPresent()) {
            Conversion existingConversion = existingConversionOptional.get();
            // Update the properties of the existing conversion with the values from the updated conversion
            existingConversion.setUserId(updatedConversion.getUserId());
            existingConversion.setPointsConverted(updatedConversion.getPointsConverted());
            existingConversion.setAmountConverted(updatedConversion.getAmountConverted());
            existingConversion.setConvertedDate(updatedConversion.getConvertedDate());
            existingConversion.setConvertedRate(updatedConversion.getConvertedRate());

            return conversionRepository.save(existingConversion);
        } else {
            throw new IllegalArgumentException("Conversion not found with ID: " + conversionId);
        }
    }

    @Override
    public void deleteConversion(Long conversionId) {
        conversionRepository.deleteById(conversionId);
    }

    @Override
    public Conversion getConversionById(Long conversionId) {
        return conversionRepository.findById(conversionId)
                .orElseThrow(() -> new IllegalArgumentException("Conversion not found with ID: " + conversionId));
    }
    public double convertPointsToMoney(int points, double conversionRate) {
        return points * conversionRate;
    }
    @Override
    public List<Conversion> getAllConversions() {
        return conversionRepository.findAll();
    }

}
