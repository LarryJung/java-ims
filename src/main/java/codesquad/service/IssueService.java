package codesquad.service;

import codesquad.UnAuthenticationException;
import codesquad.domain.*;
import codesquad.dto.IssueDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.EntityNotFoundException;

@Service("issueService")
public class IssueService {

    @Resource(name = "issueRepository")
    private IssueRepository issueRepository;

    @Resource(name = "milestoneRepository")
    private MilestoneRepository milestoneRepository;

    public Issue save(User loginUser, IssueDto issueDto) {
        Issue newIssue = issueDto._toIssue();
        return issueRepository.save(newIssue.writtenBy(loginUser));
    }

    public Issue findById(Long id) {
        return issueRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Iterable<Issue> findAll() {
        return issueRepository.findAllByDeletedOrderByIdDesc(false);
    }

    public Issue findById(User loginUser, Long id) throws UnAuthenticationException {
        return issueRepository.findById(id)
                .filter(issue -> issue.isWriter(loginUser))
                .orElseThrow(UnAuthenticationException::new);
    }

    @Transactional
    public Issue update(User loginUser, Long id, IssueDto target) throws UnAuthenticationException {
        return findById(loginUser, id).update(target);
    }

    @Transactional
    public Issue delete(User loginUser, Long id) throws UnAuthenticationException {
        return findById(loginUser, id).delete();
    }

    public void setMilestone(Long issueId, Milestone milestone) {
        issueRepository.save(findById(issueId).registerMilestone(milestone));
    }

    @Transactional
    public void setAssignee(Long issueId, User assignee) {
        findById(issueId).assignDirector(assignee);
    }
}
