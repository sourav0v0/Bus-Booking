package pojo;

public class Customer {

		private String custName,custEmailId,custPassword,custContactNo,custAddress;private int custPoints;
		public Customer()
		{
			
		}
		
		public int getCustPoints() {
			return custPoints;
		}

		public void setCustPoints(int custPoints) {
			this.custPoints = custPoints;
		}

		public Customer(String custName, String custEmailId, String custPassword, String custContactNo,
				String custAddress, int custPoints) {
			super();
			this.custName = custName;
			this.custEmailId = custEmailId;
			this.custPassword = custPassword;
			this.custContactNo = custContactNo;
			this.custAddress = custAddress;
			this.custPoints = custPoints;
		}
		public Customer(String custName, String custEmailId, String custPassword, String custContactNo,
				String custAddress) {
			super();
			this.custName = custName;
			this.custEmailId = custEmailId;
			this.custPassword = custPassword;
			this.custContactNo = custContactNo;
			this.custAddress = custAddress;
		}
		public String getCustName() {
			return custName;
		}
		public void setCustName(String custName) {
			this.custName = custName;
		}
		public String getCustEmailId() {
			return custEmailId;
		}
		public void setCustEmailId(String custEmailId) {
			this.custEmailId = custEmailId;
		}
		public String getCustPassword() {
			return custPassword;
		}
		public void setCustPassword(String custPassword) {
			this.custPassword = custPassword;
		}
		public String getCustContactNo() {
			return custContactNo;
		}
		public void setCustContactNo(String custContactNo) {
			this.custContactNo = custContactNo;
		}
		public String getCustAddress() {
			return custAddress;
		}
		public void setCustAddress(String custAddress) {
			this.custAddress = custAddress;
		}
		@Override
		public String toString() {
			return "Customer [custName=" + custName + ", custEmailId=" + custEmailId + ", custPassword=" + custPassword
					+ ", custContactNo=" + custContactNo + ", custAddress=" + custAddress + ", custPoints=" + custPoints
					+ "]";
		}
	}


