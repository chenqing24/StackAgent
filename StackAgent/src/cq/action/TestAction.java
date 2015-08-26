package cq.action;

import cq.core.action.BaseAction;

/**
 * 测试Action
 * @author chenqing24@163.com
 */
public class TestAction extends BaseAction {

	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		this.putTplMap("hi", "hello");
        try {
			this.tplPrint("hi");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
