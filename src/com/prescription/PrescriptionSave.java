package com.prescription;


import com.opensymphony.xwork2.ActionSupport;

public class PrescriptionSave extends ActionSupport {

    private static final long serialVersionUID = 1L;


    private Long prescriptionid;
    private String medicalid;
    private String [] ccname;
    private String [] cctype;
    private String [] comments;
    private String [] oename;
    private String [] oecomments;

   
    
    
    public String execute() throws Exception
	{
		
    	
    	
    	
    	
    	PrescriptionDAO pDao=new PrescriptionDAO();
    	   	
    
    	
    	pDao.insertCC(ccname, cctype, comments, prescriptionid, medicalid);
    	pDao.insertOE(prescriptionid,oename, oecomments, medicalid);
    	
    	
    	
    	return "success";  	
    	
	}
    /*public String savecc() {

	List <PrescriptionSave> idList = new ArrayList<PrescriptionSave>();
	
	
	//String [] st = ccname.split(","); 
	
	for(int i=0; i<ccname.length;i++)	
	{
		PrescriptionSave id = new PrescriptionSave ();
		id.getPrescriptionid();
		id.getCcname();
		id.getCctype();
		id.getComments();
		id.getMedicalid();
					
		idList.add(id);
	}
	
	PrescriptionDAO pDao = new PrescriptionDAO();
	
	pDao.saveIssueDetail(idList);

        int cc = 0;

        PrescriptionDAO pDao = new PrescriptionDAO();

        cc = pDao.save(this);
        if (cc > 0) {
            return "success";
        }
        return "success";

    }

    public String saveoe() {

        int oe = 0;


        PrescriptionDAO pDao = new PrescriptionDAO();

        oe = pDao.saveOE(this);
        if (oe > 0) {
            return "success";
        }
        return "success";
    }

*/
    public String getMedicalid() {
        return medicalid;
    }

    public void setMedicalid(String medicalid) {
        this.medicalid = medicalid;
    }

    

    public Long getPrescriptionid() {
        return prescriptionid;
    }


    public void setPrescriptionid(Long prescriptionid) {
        this.prescriptionid = prescriptionid;
    }


}
