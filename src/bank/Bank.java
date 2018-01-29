package bank;

import java.util.ArrayList;

public class Bank {
	
	private ArrayList<Branch> branches;
	
	public Bank(){
		branches = new ArrayList<Branch>();
	}
	
	public boolean addBranch(Branch branch){
		if(!branchAlreadyExists(branch)){
			branches.add(branch);
			return true;
		}
		return false;
	}

	public int allBranches() {
		return branches.size();
	}
	
	private boolean branchAlreadyExists(Branch branch){
		for(int i=0; i<branches.size(); i++){
			Branch branchToEvaluate = branches.get(i);
			if(branchToEvaluate.getId() == branch.getId() || branchToEvaluate.getPostcode() == branch.getPostcode()){
				return true;
			}
		}
		return false;
	}

	public boolean removeBranchByID(String string){
		for(int i=0; i<branches.size(); i++){
			Branch branch = branches.get(i);
			if(branch.getId() == string){
				branches.remove(i);
				return true;
			}
		}
		return false;
	}

	public ArrayList<Branch> getBranches(){
		return branches;
	}
}
