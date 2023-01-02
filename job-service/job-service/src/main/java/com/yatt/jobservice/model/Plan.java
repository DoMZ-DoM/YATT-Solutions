package com.yatt.jobservice.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.yatt.jobservice.controller.exceptions.UnsupportedPlanException;



@Document(collection = "plan")
public class Plan {
	/**
	 * PACKAGE-TYPE - Trails, Gold, Silver, DAIMOND PACKAGE-DURATION - 7 day, 30
	 * days, 15 days, 3 months PACKAGE-PRICE - 0, 10$, 20$, 30$ PACKAGE-STATUS -
	 * ACTIVATED - EXPIRED - DEACTIVATED - NA PACKAGE-BENEFITS ALLOWED-JOB-POSTS:
	 * Number of job posts one can do within a subscription:
	 */
	public enum Type {
		TRAIL, STANDARD, PREMIUM;
	};

	private enum Benefits {
		JOBPOSTING, FAIRPOSTING, CUSTOMERSUPPORT, STAFFINGCONSTULTAION, UNLIMITEDUSERS, VIDEOINTERVIEW;
	};
	
	@Id
	private String planId;
	private String companId; //refactor later
	private String adminId;
	private Benefits benefits;
	private Type type;
	private String duration;
	private int price;
	private Trail trail = null;
	private Standard standard = null;
	private Premium premium = null;
	
	public Plan() {}

	Plan(Benefits benefits, Type type) {
		this.benefits = benefits;
		this.type = type;
	}
	
	/**
	 *  Construct the plan from provided and supported plan types
	 * @param type
	 * @throws UnsupportedPlanException
	 */
	public Plan(Type type) throws UnsupportedPlanException {
		this.type = type;
		if(this.type.equals(Type.TRAIL)) {
			this.trail = new Trail();
		}else if (this.type.equals(Type.STANDARD)) {
			this.standard = new Standard();
		}else if (this.type.equals(Type.PREMIUM)) {
			this.premium = new Premium();
		}else {
			throw new UnsupportedPlanException(String.format("Unsupported plan type [%s]",type));
		}
	}

	private enum Status {
		ACTIVATED, EXPIRED, DEACTIVATED, NA;
	}

	/**
	 * @return the benefits
	 */
	public Benefits getBenefits() {
		return benefits;
	}

	/**
	 * @param benefits the benefits to set
	 */
	public void setBenefits(Benefits benefits) {
		this.benefits = benefits;
	}
	

	/**
	 * @return the planId
	 */
	public String getPlanId() {
		return planId;
	}

	/**
	 * @param planId the planId to set
	 */
	public void setPlanId(String planId) {
		this.planId = planId;
	}

	/**
	 * @return the companId
	 */
	public String getCompanId() {
		return companId;
	}

	/**
	 * @param companId the companId to set
	 */
	public void setCompanId(String companId) {
		this.companId = companId;
	}

	/**
	 * @return the adminId
	 */
	public String getAdminId() {
		return adminId;
	}

	/**
	 * @param adminId the adminId to set
	 */
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	/**
	 * @return the type
	 */
	public Type getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(Type type) {
		this.type = type;
	}

	/**
	 * @return the duration
	 */
	public String getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(String duration) {
		this.duration = duration;
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	

	/**
	 * @return the trail
	 */
	public Trail getTrail() {
		return trail;
	}
	/**
	 * @param trail the trail to set
	 */
	public void setTrail(Trail trail) {
		this.trail = trail;
	}
	/**
	 * @return the standard
	 */
	public Standard getStandard() {
		return standard;
	}
	/**
	 * @param standard the standard to set
	 */
	public void setStandard(Standard standard) {
		this.standard = standard;
	}
	/**
	 * @return the premium
	 */
	public Premium getPremium() {
		return premium;
	}
	/**
	 * @param premium the premium to set
	 */
	public void setPremium(Premium premium) {
		this.premium = premium;
	}



	public static class Trail {
		private List<Plan.Benefits> packageBenefits;
		private Plan.Type type = Type.TRAIL;
		private int duration = 0; //months

		Trail() {
			this.duration = 2;
			this.packageBenefits = new ArrayList<Plan.Benefits>() {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				{
					add(Benefits.CUSTOMERSUPPORT);
					add(Benefits.FAIRPOSTING);
					add(Benefits.JOBPOSTING);
					add(Benefits.STAFFINGCONSTULTAION);
					add(Benefits.UNLIMITEDUSERS);
					add(Benefits.VIDEOINTERVIEW);
				}
			};
		}

		/**
		 * @return the duration
		 */
		public int getDuration() {
			return duration;
		}

		/**
		 * @param duration the duration to set
		 */
		public void setDuration(int duration) {
			this.duration = duration;
		}

		public List<Plan.Benefits> getPackageBenefits() {
			return packageBenefits;
		}

		public void setPackageBenefits(List<Plan.Benefits> packageBenefits) {
			this.packageBenefits = packageBenefits;
		}

		public Plan.Type getType() {
			return type;
		}

		public void setType(Plan.Type type) {
			this.type = type;
		}

	}

	public static class Standard {

		private Plan.Type type = Type.STANDARD;
		private List<Plan.Benefits> packageBenefits = null;
		private int duration = 0;

		public Standard() {
			this.duration = 1;  // in months
			this.packageBenefits = new ArrayList<Plan.Benefits>() {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				{
					add(Benefits.CUSTOMERSUPPORT);
					add(Benefits.FAIRPOSTING);
					add(Benefits.JOBPOSTING);
					add(Benefits.UNLIMITEDUSERS);
					add(Benefits.VIDEOINTERVIEW);
				}
			};
		}

		
		/**
		 * @return the duration
		 */
		public int getDuration() {
			return duration;
		}


		/**
		 * @param duration the duration to set
		 */
		public void setDuration(int duration) {
			this.duration = duration;
		}


		/**
		 * @return the type
		 */
		public Plan.Type getType() {
			return type;
		}

		/**
		 * @param type the type to set
		 */
		public void setType(Plan.Type type) {
			this.type = type;
		}

		/**
		 * @return the packageBenefits
		 */
		public List<Plan.Benefits> getPackageBenefits() {
			return packageBenefits;
		}

		/**
		 * @param packageBenefits the packageBenefits to set
		 */
		public void setPackageBenefits(List<Plan.Benefits> packageBenefits) {
			this.packageBenefits = packageBenefits;
		}

	}

	/**
	 * 
	 * @author ayich
	 * Premium package initializations
	 *
	 */
	public static class Premium {
		private List<Plan.Benefits> packageBenefits;
		private Plan.Type type = Type.PREMIUM;
		private int duration = 0;

		public Premium() {
			this.duration = 1;
			this.packageBenefits = new ArrayList<Plan.Benefits>() {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				{
					add(Benefits.CUSTOMERSUPPORT);
					add(Benefits.FAIRPOSTING);
					add(Benefits.JOBPOSTING);
					add(Benefits.UNLIMITEDUSERS);
					add(Benefits.VIDEOINTERVIEW);
					add(Benefits.STAFFINGCONSTULTAION);
				}
			};

		}
		

		/**
		 * @return the duration
		 */
		public int getDuration() {
			return duration;
		}


		/**
		 * @param duration the duration to set
		 */
		public void setDuration(int duration) {
			this.duration = duration;
		}


		/**
		 * @return the packageBenefits
		 */
		public List<Plan.Benefits> getPackageBenefits() {
			return packageBenefits;
		}

		/**
		 * @param packageBenefits the packageBenefits to set
		 */
		public void setPackageBenefits(List<Plan.Benefits> packageBenefits) {
			this.packageBenefits = packageBenefits;
		}

		/**
		 * @return the type
		 */
		public Plan.Type getType() {
			return type;
		}

		/**
		 * @param type the type to set
		 */
		public void setType(Plan.Type type) {
			this.type = type;
		}

	}
}
