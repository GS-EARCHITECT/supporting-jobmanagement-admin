package job_template_master_mgmt.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import job_template_master_mgmt.model.master.JobTemplateMaster;
import job_template_master_mgmt.model.master.JobTemplateMasterPK;

@Repository("jobTemplateMasterRepo")
public interface JobTemplateMasterRepo extends CrudRepository<JobTemplateMaster, JobTemplateMasterPK> 
{	
	@Modifying
	@Query(value="delete from JOB_TEMPLATE_MASTER  where JOB_TYPE_SEQ_NO in :jobTemplateMasterSeqNos", nativeQuery = true)
	void deleteSelectJobTemplateMasters(@Param("jobTemplateMasterSeqNos") ArrayList<Long> jobTemplateMasterSeqNos);
	
	@Query(value = "SELECT * JOB_TEMPLATE_MASTER where JOB_TYPE_SEQ_NO in :jobTemplateMasterSeqNos ORDER BY JOB_TYPE_SEQ_NO",nativeQuery = true) 
	ArrayList<JobTemplateMaster> getSelectJobTemplateMasters(@Param("jobTemplateMasterSeqNos") ArrayList<Long> jobTemplateMasterSeqNos);
}