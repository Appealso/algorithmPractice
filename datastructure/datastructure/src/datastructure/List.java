package datastructure;

public class List {
	public static void main(String[] args) {
	
	}
	//ù��° ��ũ���带 ����Ű�� �ʵ�
	private ListNode head;
	private ListNode tail;
	
	//ù��° ���߿��Ḯ��Ʈ�� ����Ű�� �ʵ�
	private DLLNode dllhead;
	private DLLNode dlltail;
	
	//�迭����Ʈ ��ü
	private int ALSize=0;
	private Object[] ALData = new Object[100];

	//�ܼ����� ����Ʈ ���
	private class ListNode{
		private Object data;
		private ListNode next;
		public ListNode(Object data) { 
			this.data=data; 
			this.next=null;
		}
	}
	
	//���߿��Ḯ��Ʈ ���
	static class DLLNode{
		private Object data;
		private DLLNode next;
		private DLLNode previous;
		public DLLNode(Object data) { 
			this.data=data;
			this.next=null;
			this.previous=null;
		}
	}
	//��������Ʈ ���
	static class CLLNode{
		private Object data;
		private CLLNode next;
		public CLLNode(Object data) {
			this.data=data;
			this.next=null;
		}
	}
	//�迭����Ʈ ��� �߰�
	public boolean ALAdd(int position, Object AList) {
		for(int i=ALSize-1;i>=position;i--) ALData[i+1]=ALData[i];
		ALData[position]=AList;
		ALSize++;
		return true;
	}
	//�迭����Ʈ��� ����
	public Object ALRemove(int position) {
		Object removed = ALData[position];
		for(int i=position+1;i<=ALSize-1;i++) ALData[i-1]=ALData[i];
		ALSize--;
		ALData[ALSize]=null;
		return removed;
	}
	
	//��ũ�帮��Ʈ��� �߰�
    public void LLadd(int position, Object list){
        if(position == 0){ 
        	ListNode newNode = new ListNode(list);
        	newNode.next=head;
        	head=newNode;
        	if(head.next==null) { tail=head; }
        } 
        else {
        	//��� �̵�
        	ListNode node = head;
        	for(int i=0;i<position-1;i++) node=node.next;

            ListNode temp1 = node;
            ListNode temp2 = temp1.next;
            ListNode newNode = new ListNode(list);
            temp1.next = newNode;
            newNode.next = temp2;

            if(newNode.next == null) tail = newNode;
        }
    }

    //��ũ�� ����Ʈ ������
    public Object LLremove(int position){
        if(position == 0) {
            ListNode temp = head;
            head = temp.next;
            Object returnData = temp.data;
            temp = null;
            return returnData;
        }
    	ListNode node = head;
    	for(int i=0;i<position-1;i++) node=node.next;

        ListNode todoDeleted = node.next;
        node.next = node.next.next;
        Object returnData = todoDeleted.data; 
        if(todoDeleted == tail){
            tail = node;
        }
        todoDeleted = null; 
        return returnData;
    }
    
    //���߿��Ḯ��Ʈ �߰�
    public void DLLadd(int position, Object list){
    	if(position == 0){ 
    		DLLNode newNode = new DLLNode(list);
    		newNode.next=dllhead;
    		if(dllhead!=null) dllhead.previous=newNode;
    		dllhead=newNode;
    		if(dllhead.next==null) { dlltail=dllhead; }
        } else {
        	//��� �̵�
        	DLLNode node = dllhead;
        	for(int i=0;i<position-1;i++) node=node.next;

        	DLLNode temp1 = node;
        	DLLNode temp2 = temp1.next;
        	DLLNode newNode = new DLLNode(list);
            temp1.next = newNode;
            newNode.next = temp2;
            if(temp2!=null) temp2.previous=newNode;
            newNode.previous=temp1;
            if(newNode.next == null) dlltail = newNode;
        }
    }
    
    //���߿��� ����Ʈ ������
    public Object DLLremove(int position){
        if(position == 0) {
            DLLNode temp = dllhead;
            dllhead = temp.next;
            Object returnData = temp.data;
            temp = null;
            if(dllhead!=null) dllhead.previous=null;
            return returnData;
        }
    	DLLNode node = dllhead;
    	for(int i=0;i<position-1;i++) node=node.next;

        DLLNode todoDeleted = node.next;
        node.next = node.next.next;
        
        if(node.next!=null) node.next.previous=node;
        
        Object returnData = todoDeleted.data; 
        
        if(todoDeleted == dlltail){
            dlltail = node;
        }
        todoDeleted = null; 
        return returnData;
    }
    
}