package com.example.app.Service;

import com.example.app.Models.Branch;
import com.example.app.Repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BranchServiceImp implements BranchService{
    private final BranchRepository branchRepository;

    @Autowired
    public BranchServiceImp(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    @Override
    public List<Branch> getAllBranches() {
        return branchRepository.findAll();
    }

    @Override
    public Optional<Branch> getBranchById(Long branchId) {
        return branchRepository.findById(branchId);
    }

    @Override
    public Branch createBranch(Branch branch) {
        return branchRepository.save(branch);
    }

    @Override
    public Branch updateBranch(Long branchId, Branch branch) {
        Branch existingBranch = branchRepository.findById(branchId).orElse(null);
        if (existingBranch != null) {
            existingBranch.setBranchName(branch.getBranchName());
            existingBranch.setAddress(branch.getAddress());
            existingBranch.setCity(branch.getCity());
            existingBranch.setState(branch.getState());
            existingBranch.setCountry(branch.getCountry());
            existingBranch.setZipCode(branch.getZipCode());
            existingBranch.setPhoneNumber(branch.getPhoneNumber());
            existingBranch.setEmail(branch.getEmail());
            return branchRepository.save(existingBranch);
        }
        return null;
    }

    @Override
    public void deleteBranch(Long branchId) {
        branchRepository.deleteById(branchId);
    }

}
