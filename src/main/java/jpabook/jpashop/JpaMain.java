package jpabook.jpashop;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Team;

public class JpaMain {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		try {
				
			// 저장
			Team team = new Team();
			team.setName("TeamA");
			em.persist(team);
			
			Member member = new Member();
			member.setName("member1");
			member.setTeam(team);
			em.persist(member); 
			
			// DB에서 직접가져오고싶을 때.
			em.flush();
			em.clear();
			
			// 조회
			Member findMember = em.find(Member.class, member.getId());
			//Team findTeam =  findMember.getTeam();
			
			// 새로운 팀을 가져오고싶은 경우.
			//  findTeam.setName("test~");
			
			//System.out.println("findTeam = " + findTeam.getName()  );
			
			//System.out.println(findMember.getTeam().getName());
			List<Member>   members = findMember.getTeam().getMembers();
			
			for(Member member2 : members) {
				System.out.println("m = " + member2.getName());
			}
			
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
			emf.close();
		}
	}

}
