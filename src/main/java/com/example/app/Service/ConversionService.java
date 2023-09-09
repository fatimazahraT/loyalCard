package com.example.app.Service;

import com.example.app.Models.Conversion;

import java.util.List;

public interface ConversionService {
    Conversion createConversion(Conversion conversion);
    Conversion updateConversion(Long conversionId, Conversion updatedConversion);
    void deleteConversion(Long conversionId);
    Conversion getConversionById(Long conversionId);
    List<Conversion> getAllConversions();
    double convertPointsToMoney(int points, double conversionRate);
}
