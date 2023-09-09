package com.example.app.Service;

import com.example.app.Models.Branch;

import java.util.List;
import java.util.Optional;

public interface BranchService {
    List<Branch> getAllBranches();
    Optional<Branch> getBranchById(Long branchId);
    Branch createBranch(Branch branch);
    Branch updateBranch(Long branchId, Branch branch);
    void deleteBranch(Long branchId);
}
