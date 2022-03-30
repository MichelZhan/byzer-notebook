package io.kyligence.notebook.console.service;

import io.kyligence.notebook.console.NotebookLauncherTestBase;
import io.kyligence.notebook.console.bean.entity.WorkflowInfo;
import io.kyligence.notebook.console.dao.WorkflowRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class WorkflowServiceTest extends NotebookLauncherTestBase {

    @Autowired
    private WorkflowService workflowService;

    @Autowired
    private WorkflowRepository workflowRepository;

    private Integer mockWorkflowId;

    private final String mockWorkflowName = "mock-workflow";

    @Override
    @PostConstruct
    public void mock() {
        WorkflowInfo workflowInfo = new WorkflowInfo();
        workflowInfo.setUser(DEFAULT_ADMIN_USER);
        workflowInfo.setName(mockWorkflowName);
        workflowInfo = workflowRepository.save(workflowInfo);
        mockWorkflowId = workflowInfo.getId();
    }


    @Test
    public void testFindById() {
        WorkflowInfo workflowInfo = workflowService.findById(mockWorkflowId);
        Assert.assertNotNull(workflowInfo);
        Assert.assertEquals(mockWorkflowId, workflowInfo.getId());
        Assert.assertEquals(mockWorkflowName, workflowInfo.getName());
    }

    @Test
    public void testFind() {
        WorkflowInfo workflowInfo = workflowService.find(DEFAULT_ADMIN_USER, mockWorkflowName, null);
        Assert.assertNotNull(workflowInfo);
        Assert.assertEquals(mockWorkflowName, workflowInfo.getName());
    }

    @Test
    public void testCreate() {
        WorkflowInfo workflowInfo = workflowService.create(DEFAULT_ADMIN_USER,);
    }
}
