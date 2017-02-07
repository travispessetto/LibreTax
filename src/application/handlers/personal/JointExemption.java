package application.handlers.personal;

import application.handlers.IInterview;

public class JointExemption implements IInterview
{
	private PrimaryInfo primaryInfo;
	private SpouseInfo spouseInfo;
	public JointExemption(PrimaryInfo primary, SpouseInfo spouse)
	{
		primaryInfo = primary;
		spouseInfo = spouse;
	}

	@Override
	public IInterview Next() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IInterview Prev() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String ShowView() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void AcceptJSON(String json) {
		// TODO Auto-generated method stub
		
	}

}
