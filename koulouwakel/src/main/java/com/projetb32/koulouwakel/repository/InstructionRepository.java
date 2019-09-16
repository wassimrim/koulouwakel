package com.projetb32.koulouwakel.repository;

import com.projetb32.koulouwakel.entity.Instruction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InstructionRepository extends JpaRepository <Instruction,Long> {

    public List<Instruction> findInstructionByStep_Id(long id);

}
