package jpabook.jpashop.main;

import jpabook.jpashop.domain.Book;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class main {

    public static void main(String[] args) {
//      어플리케이션 실행시점에서 딱 1개 생성되는 entityManagerFactory(공유 하면 안됨)
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

//      요청시에 생성
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

//      code!!!
        try{

            Book book = new Book();
            book.setName("JPA");
            book.setAuthor("편도훈");

            em.persist(book);

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
