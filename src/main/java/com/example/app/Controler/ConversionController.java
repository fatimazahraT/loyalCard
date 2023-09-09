package com.example.app.Controler;
import com.example.app.Models.Conversion;
import com.example.app.Service.ConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conversions")
public class ConversionController {

    private final ConversionService conversionService;

    @Autowired
    public ConversionController(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @GetMapping("/{conversionId}")
    public ResponseEntity<Conversion> getConversionById(@PathVariable Long conversionId) {
        Conversion conversion = conversionService.getConversionById(conversionId);
        return ResponseEntity.ok(conversion);
    }

    @GetMapping
    public ResponseEntity<List<Conversion>> getAllConversions() {
        List<Conversion> conversions = conversionService.getAllConversions();
        return ResponseEntity.ok(conversions);
    }

    @PostMapping
    public ResponseEntity<Conversion> createConversion(@RequestBody Conversion conversion) {
        Conversion createdConversion = conversionService.createConversion(conversion);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdConversion);
    }

    @PutMapping("/{conversionId}")
    public ResponseEntity<Conversion> updateConversion(@PathVariable Long conversionId, @RequestBody Conversion updatedConversion) {
        Conversion conversion = conversionService.updateConversion(conversionId, updatedConversion);
        return ResponseEntity.ok(conversion);
    }

    @DeleteMapping("/{conversionId}")
    public ResponseEntity<Void> deleteConversion(@PathVariable Long conversionId) {
        conversionService.deleteConversion(conversionId);
        return ResponseEntity.noContent().build();
    }
}

