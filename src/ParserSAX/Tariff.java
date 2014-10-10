package ParserSAX;


public class Tariff {
	
		private String title, id;
		private int payroll;
		private double smsprice;
			
		public Callprices cp = new Callprices();
		public Parameters par = new Parameters();
		
		public void setCallprices(Callprices cp) {
			this.cp = cp;
		}
		
		public void setParameters(Parameters par) {
			this.par = par;
		}

		public void setId(String id) {
			this.id = id;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public void setPayroll(int payroll) {
			this.payroll = payroll;
		}
		
		public void setSmsprice(double smsprice) {
			this.smsprice = smsprice;
		}
		@Override
		public String toString() {
			return "\nId:" + id + " " + "Tariffname: " + title + " " + "Payroll: " + payroll + " " 
			+ "\n\t callprices: " + cp.insidenetwork + " " + cp.outsidenetwork + " " + cp.tofixedphones + " " 
			+ "\n\t smsprice: " + smsprice + " " 
			+ "\n\t parameters: " + par.favouritenumbers + " " + par.tariffing + " " + par.connectpayment + " ";
		}

		class Callprices {
			double insidenetwork, outsidenetwork, tofixedphones;

			public void setInsidenetwork(double insidenetwork) {
				this.insidenetwork = insidenetwork;
			}

			public void setOutsidenetwork(int outsidenetwork) {
				this.outsidenetwork = outsidenetwork;
			}

			public void setTofixedphones(int tofixedphones) {
				this.tofixedphones = tofixedphones;
			}
		}
		
		class Parameters {
			
			String tariffing;
			int favouritenumbers;
			int connectpayment;
			
			public void setTariffing(String tariffing) {
				this.tariffing = tariffing;
			}
					
			public void setFavouritenumbers(int favouritenumbers) {
				this.favouritenumbers = favouritenumbers;
			}
			
			public void setConnectpayment(int connectpayment) {
				this.connectpayment = connectpayment;
			}
			
		}
	}

