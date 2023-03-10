package com.itvitae.swdn.repository;

import com.itvitae.swdn.model.DBFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DBFileRepository extends JpaRepository<DBFile, Long> {
}
