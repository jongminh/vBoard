package com.jongminhong.vboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jongminhong.vboard.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long>{

	public Board findByName(String name);
}
