package umc.spring.repository.MissionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Member;

public interface MissionRepository extends JpaRepository<Member, Long>, MissionRepositoryCustom {

}
