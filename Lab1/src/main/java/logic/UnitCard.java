	package logic;

	public class UnitCard {
		private String name;
		private int bloodCost;
		private int power;
		private int health;
		private String flavorText;


		public UnitCard(String name, int bloodCost, int power, int health, String flavorText){
			this.setName(name);
			this.setBloodCost(bloodCost);
			this.setPower(power);
			this.setHealth(health);
			this.setFlavorText(flavorText);
		}

		public void setName(String newName) {
			if (!newName.isBlank()) {
				this.name = newName;
			}
			else{
				this.name = "Creature";
			}
		}

		public void setBloodCost(int newBloodCost){
			this.bloodCost = Math.max(newBloodCost, 0);
			}

		public void setPower(int newPower){
			this.power = Math.max(newPower, 0);
		}

		public void setHealth(int newHealth){
			this.health = Math.max(newHealth, 1);
		}

		public boolean equals(UnitCard other){
			if (other == null || other.name == null || this.name == null) {
				return false;
			}
			return this.name.equals(other.name);
		}
		public void setFlavorText(String newText){
			if (newText != null && !newText.isBlank())
			{ this.flavorText = newText; }
			else {
				this.flavorText = "No flavor text"; }
		}

		public String getName() {
			return name;
		}
		public int getBloodCost(){
			return bloodCost;
		}
		public int getPower(){
			return power;
		}
		public int getHealth(){
			return health;
		}
		public String getFlavorText(){
			return flavorText;
		}
		public String toString() {
			return this.getName() + " (POW: " + this.getPower() + ", HP: " + this.getHealth() + ")";
		}
		}
