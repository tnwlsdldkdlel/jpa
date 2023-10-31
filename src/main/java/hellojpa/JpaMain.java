package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		try {
//			Member findMember = em.find(Member.class, 1L);
//			System.out.println("findMember.id = " + findMember.getId());
//			System.out.println("findMember.name = " + findMember.getName());

//			em.remove(findMember);

//			findMember.setName("HelloJPA");

//			List<Member> result = em.createQuery("select m from Member as m", Member.class)
//					.setFirstResult(1)
//					.setMaxResults(2)
//					.getResultList();
//			
//			for(Member member : result) {
//				System.out.println("member.name = " + member.getName());
//			}

//			Member member = new Member();
//			member.setId(2L);
//			member.setName("helloB");
//			em.persist(member);

			// 비영속
//			Member member = new Member();
//			member.setId(101L);
//			member.setName("HelloJPA");
//			
//			// 영속
//			System.out.println("===== before =====");
//			em.persist(member);
//			System.out.println("===== after =====");
//			
//			// 1차캐시에 저장된 값을 가져옴. 
//			Member findMember = em.find(Member.class, 101L);
//			
//			System.out.println("member.id ==> " + findMember.getId());
//			System.out.println("member.name ==> " + findMember.getName());

			// 영속
			// 1차캐시에 없어서 DB에 저장하고
//			Member findMember1 = em.find(Member.class, 101L);
//
//			// 1차캐시에 있으니까 캐시에서 가져옴.
//			Member findMember2 = em.find(Member.class, 101L);
//
//			System.out.println("result => " + (findMember1 == findMember2));
//
//			Member membr1 = new Member(150L, "A");
//			Member membr2 = new Member(160L, "B");
//			
//			em.persist(membr1);
//			em.persist(membr2);
//			
//			System.out.println("===============");
			
//			Member findMember = em.find(Member.class, 150L);
//			findMember.setName("ZZZZ");
			
//			Member member = new Member(200L, "member200");
//			em.persist(member);
//			
//			// commint하기전에 DB반영 -> 영속성 컨테스트의 변경내용을 데이터베이스에 동기화.
//			// 쓰기지연 SQL 저장소에 저장된 쿼리만 날리고 캐시는 그대로 유지.
//			em.flush();
			
//			Member member = em.find(Member.class, 150L);
//			member.setName("AAAAA");
//			
//			// 준영속상태가 되버림 -> 영속성 컨테스트에서 관리안함.
//			em.detach(member);
//			
//			// 영속성 컨테스트 자체를 비움.
//			em.clear(); 
	
//			System.out.println("===============");
//			
//			Member2 member = new Member2();
//			member.setUsername("test1");
//			
//			System.out.println("===============");
//			em.persist(member); // IDENTITY인 경우 여기서 바로 쿼리 실행됨.
//			System.out.println(member.getId());
//			System.out.println("===============");
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
			emf.close();
		}
	}

}
