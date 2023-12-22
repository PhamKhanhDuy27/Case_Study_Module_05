package com.codegym.thi.service.Impl;

import com.codegym.thi.dto.BranchDto;
import com.codegym.thi.entity.Branch;
import com.codegym.thi.repository.BranchRepository;
import com.codegym.thi.service.IBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BranchService implements IBranchService {

    @Autowired
    private BranchRepository branchRepository;

    public List<BranchDto> getAll() {
        List<Branch> branches = branchRepository.findAll();
        List<BranchDto> branchDtos = new ArrayList<>();
        for(Branch branch : branches) {
            BranchDto branchDto = new BranchDto();
            branchDto.setId(branch.getId());
            branchDto.setName(branch.getName());
            branchDtos.add(branchDto);
        }
        return branchDtos;
    }
}
