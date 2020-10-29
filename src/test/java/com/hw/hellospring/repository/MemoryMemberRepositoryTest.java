package com.hw.hellospring.repository;

import com.hw.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        memoryMemberRepository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("Test1");

        memoryMemberRepository.save(member);

        Member result = memoryMemberRepository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("name1");
        memoryMemberRepository.save(member1);

        Member member2 = new Member();
        member2.setName("name2");
        memoryMemberRepository.save(member2);

        Member result = memoryMemberRepository.findByName("name1").get();

        assertThat(result).isEqualTo("name1");



    }
}
