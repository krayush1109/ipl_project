package com.wecp.progressive.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wecp.progressive.entity.Vote;
import com.wecp.progressive.repository.VoteRepository;

@Service
public class VoteServiceImpl  {

    @Autowired
    private VoteRepository voteRepository;

    
    public ResponseEntity<List<Vote>> getAllVotes() { 
        List<Vote> votes = voteRepository.findAll(); 
        return ResponseEntity.ok(votes); 
    } 
    
    public ResponseEntity<Integer> createVote(Vote vote) { 
        Vote savedVote = voteRepository.save(vote); 
        return ResponseEntity.status(201).body(savedVote.getVoteId()); 
    } 
    
    public ResponseEntity<Map<String, Long>> getVotesCountOfAllCategories() { 
        List<Vote> votes = voteRepository.findAll(); 
        
        Map<String, Long> countMap = votes.stream() 
                        .collect(Collectors.groupingBy(Vote::getCategory, Collectors.counting())); 
        return ResponseEntity.ok(countMap);
    }
}