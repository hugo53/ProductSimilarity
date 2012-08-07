package hd.product;

import hd.bestbuy.crawler.ProcessData;

public class Laptop {

	// Review attrs
	// f compare

	// Attributes
	private String title;
	private String name;
	private String model;
	private String screen;
	private String ram;
	private String ram_max_support;
	private String hdd_size;
	private String hdd_type;
	private String optical_drive;
	private String weight;
	private String graphics_card;
	private String os;
	private String cpu_type;
	private String cpu_speed;
	private String cpu_cache;
	private String battery_type;
	private String warranty;
	private String price;

	public Laptop() {
	}

	/**
	 * @param title
	 * @param name
	 * @param model
	 * @param screen
	 * @param ram
	 * @param ram_max_support
	 * @param hdd_size
	 * @param hdd_type
	 * @param optical_drive
	 * @param weight
	 * @param graphics_card
	 * @param os
	 * @param cpu_type
	 * @param cpu_speed
	 * @param cpu_cache
	 * @param battery_type
	 * @param warranty
	 * @param price
	 */
	public Laptop(String title, String name, String model, String screen,
			String ram, String ram_max_support, String hdd_size,
			String hdd_type, String optical_drive, String weight,
			String graphics_card, String os, String cpu_type, String cpu_speed,
			String cpu_cache, String battery_type, String warranty, String price) {
		super();
		this.title = title;
		this.name = name;
		this.model = model;
		this.screen = screen;
		this.ram = ram;
		this.ram_max_support = ram_max_support;
		this.hdd_size = hdd_size;
		this.hdd_type = hdd_type;
		this.optical_drive = optical_drive;
		this.weight = weight;
		this.graphics_card = graphics_card;
		this.os = os;
		this.cpu_type = cpu_type;
		this.cpu_speed = cpu_speed;
		this.cpu_cache = cpu_cache;
		this.battery_type = battery_type;
		this.warranty = warranty;
		this.price = price;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model
	 *            the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return the screen
	 */
	public String getScreen() {
		return screen;
	}

	/**
	 * @param screen
	 *            the screen to set
	 */
	public void setScreen(String screen) {
		this.screen = screen;
	}

	/**
	 * @return the ram
	 */
	public String getRam() {
		return ram;
	}

	/**
	 * @param ram
	 *            the ram to set
	 */
	public void setRam(String ram) {
		this.ram = ram;
	}

	/**
	 * @return the ram_max_support
	 */
	public String getRam_max_support() {
		return ram_max_support;
	}

	/**
	 * @param ram_max_support
	 *            the ram_max_support to set
	 */
	public void setRam_max_support(String ram_max_support) {
		this.ram_max_support = ram_max_support;
	}

	/**
	 * @return the hdd_size
	 */
	public String getHdd_size() {
		return hdd_size;
	}

	/**
	 * @param hdd_size
	 *            the hdd_size to set
	 */
	public void setHdd_size(String hdd_size) {
		this.hdd_size = hdd_size;
	}

	/**
	 * @return the hdd_type
	 */
	public String getHdd_type() {
		return hdd_type;
	}

	/**
	 * @param hdd_type
	 *            the hdd_type to set
	 */
	public void setHdd_type(String hdd_type) {
		this.hdd_type = hdd_type;
	}

	/**
	 * @return the optical_drive
	 */
	public String getOptical_drive() {
		return optical_drive;
	}

	/**
	 * @param optical_drive
	 *            the optical_drive to set
	 */
	public void setOptical_drive(String optical_drive) {
		this.optical_drive = optical_drive;
	}

	/**
	 * @return the weight
	 */
	public String getWeight() {
		return weight;
	}

	/**
	 * @param weight
	 *            the weight to set
	 */
	public void setWeight(String weight) {
		this.weight = weight;
	}

	/**
	 * @return the graphics_card
	 */
	public String getGraphics_card() {
		return graphics_card;
	}

	/**
	 * @param graphics_card
	 *            the graphics_card to set
	 */
	public void setGraphics_card(String graphics_card) {
		this.graphics_card = graphics_card;
	}

	/**
	 * @return the os
	 */
	public String getOs() {
		return os;
	}

	/**
	 * @param os
	 *            the os to set
	 */
	public void setOs(String os) {
		this.os = os;
	}

	/**
	 * @return the cpu_type
	 */
	public String getCpu_type() {
		return cpu_type;
	}

	/**
	 * @param cpu_type
	 *            the cpu_type to set
	 */
	public void setCpu_type(String cpu_type) {
		this.cpu_type = cpu_type;
	}

	/**
	 * @return the cpu_speed
	 */
	public String getCpu_speed() {
		return cpu_speed;
	}

	/**
	 * @param cpu_speed
	 *            the cpu_speed to set
	 */
	public void setCpu_speed(String cpu_speed) {
		this.cpu_speed = cpu_speed;
	}

	/**
	 * @return the cpu_cache
	 */
	public String getCpu_cache() {
		return cpu_cache;
	}

	/**
	 * @param cpu_cache
	 *            the cpu_cache to set
	 */
	public void setCpu_cache(String cpu_cache) {
		this.cpu_cache = cpu_cache;
	}

	/**
	 * @return the battery_type
	 */
	public String getBattery_type() {
		return battery_type;
	}

	/**
	 * @param battery_type
	 *            the battery_type to set
	 */
	public void setBattery_type(String battery_type) {
		this.battery_type = battery_type;
	}

	/**
	 * @return the warranty
	 */
	public String getWarranty() {
		return warranty;
	}

	/**
	 * @param warranty
	 *            the warranty to set
	 */
	public void setWarranty(String warranty) {
		this.warranty = warranty;
	}

	/**
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}

	// F scores
	// for title
	public double titleSim(Laptop other, int threshold) {
		return ProcessData.simByCommonWord(this.getTitle(), other.getTitle(),
				threshold);
	}

	// for name
	public double nameSim(Laptop other, int threshold) {
		return ProcessData.simByCommonWord(this.getName(), other.getName(),
				threshold);
	}

	// for battery_type
	public double batteryTypeSim(Laptop other, int threshold) {
		return ProcessData.simByCommonWord(this.getBattery_type(),
				other.getBattery_type(), threshold);
	}

	// for cpu_cache
	public double cpuCacheSim(Laptop other, int threshold) {
		return ProcessData.simByCommonWord(this.getCpu_cache(),
				other.getCpu_cache(), threshold);
	}

	// for cpu_speed
	public double cpuSpeedSim(Laptop other, int threshold) {
		return ProcessData.simByCommonWord(this.getCpu_speed(),
				other.getCpu_speed(), threshold);
	}

	// for cpu_type
	public double cpuTypeSim(Laptop other, int threshold) {
		return ProcessData.simByCommonWord(this.getCpu_type(),
				other.getCpu_type(), threshold);
	}

	// for graphics_card
	public double graphicsCardSim(Laptop other, int threshold) {
		return ProcessData.simByCommonWord(this.getGraphics_card(),
				other.getGraphics_card(), threshold);
	}

	// for hdd_size
	public double hddSizeSim(Laptop other, int threshold) {
		return ProcessData.simByCommonWord(this.getHdd_size(),
				other.getHdd_size(), threshold);
	}

	// for hdd size
	public double hddTypeSim(Laptop other, int threshold) {
		return ProcessData.simByCommonWord(this.getHdd_type(),
				other.getHdd_type(), threshold);
	}

	// for optical drive
	public double opticalDriveSim(Laptop other, int threshold) {
		return ProcessData.simByCommonWord(this.getOptical_drive(),
				other.getOptical_drive(), threshold);
	}

	// for os
	public double osSim(Laptop other, int threshold) {
		return ProcessData.simByCommonWord(this.getOs(), other.getOs(),
				threshold);
	}

	// for model
	public double modelSim(Laptop other, int threshold) {
		return ProcessData.simByCommonWord(this.getModel(), other.getModel(),
				threshold);
	}

	// for ram
	public double ramSim(Laptop other, int threshold) {
		return ProcessData.simByCommonWord(this.getRam(), other.getRam(),
				threshold);
	}

	// for ram_max_support
	public double ramMaxSupportTypeSim(Laptop other, int threshold) {
		return ProcessData.simByCommonWord(this.getRam_max_support(),
				other.getRam_max_support(), threshold);
	}

	// for price
	public double priceSim(Laptop other, int threshold) {
		return ProcessData.simByCommonWord(this.getPrice(), other.getPrice(),
				threshold);
	}

	// for warranty
	public double warrantySim(Laptop other, int threshold) {
		return ProcessData.simByCommonWord(this.getWarranty(),
				other.getWarranty(), threshold);
	}

	// for screen
	public double screenSim(Laptop other, int threshold) {
		return ProcessData.simByCommonWord(this.getScreen(), other.getScreen(),
				threshold);
	}

	// for weight
	public double weightTypeSim(Laptop other, int threshold) {
		return ProcessData.simByCommonWord(this.getWeight(), other.getWeight(),
				threshold);
	}

	// Compute similarity score
	public double similarTo(Laptop other, int[] threshold,
			double[] featureWeights) {
		// titleSim(other, threshold[0]) * featureWeights[0]
		double totalWeight = 0;
		for (double i : featureWeights) {
			totalWeight += i;
		}

		double sim = (nameSim(other, threshold[1]) * featureWeights[1]
				+ modelSim(other, threshold[2]) * featureWeights[2]
				+ screenSim(other, threshold[3]) * featureWeights[3]
				+ ramSim(other, threshold[4]) * featureWeights[4]
				+ ramMaxSupportTypeSim(other, threshold[5]) * featureWeights[5]
				+ hddSizeSim(other, threshold[6]) * featureWeights[6]
				+ hddTypeSim(other, threshold[7]) * featureWeights[7]
				+ opticalDriveSim(other, threshold[8]) * featureWeights[8]
				+ weightTypeSim(other, threshold[9]) * featureWeights[9]
				+ graphicsCardSim(other, threshold[10]) * featureWeights[10]
				+ osSim(other, threshold[11]) * featureWeights[11]
				+ cpuTypeSim(other, threshold[12]) * featureWeights[12]
				+ cpuSpeedSim(other, threshold[13]) * featureWeights[13]
				+ cpuCacheSim(other, threshold[14]) * featureWeights[14]
				+ batteryTypeSim(other, threshold[15]) * featureWeights[15]
				+ warrantySim(other, threshold[16]) * featureWeights[16] + priceSim(
				other, threshold[17]) * featureWeights[17])
				/ (totalWeight);
		// double sim =
		/*
		 * System.out.println("name: " + nameSim(other, threshold[1]));
		 * System.out.println("model: " + modelSim(other, threshold[2]));
		 * System.out.println("screen: " + screenSim(other, threshold[3]));
		 * System.out.println("ram : " + ramSim(other, threshold[4]));
		 * 
		 * System.out.println("ram suppport: " + ramMaxSupportTypeSim(other,
		 * threshold[5])); System.out.println("hdd size: " + hddSizeSim(other,
		 * threshold[6])); System.out.println("hdd type: " + hddTypeSim(other,
		 * threshold[7])); System.out.println("optical: " +
		 * opticalDriveSim(other, threshold[8])); System.out.println("weight" +
		 * weightTypeSim(other, threshold[9])); System.out.println("graphics" +
		 * graphicsCardSim(other, threshold[10])); System.out.println("os: " +
		 * osSim(other, threshold[11])); System.out.println("cpuType " +
		 * cpuTypeSim(other, threshold[12])); System.out.println("cpu speed: " +
		 * cpuSpeedSim(other, threshold[13])); System.out.println("cpucache: " +
		 * cpuCacheSim(other, threshold[14])); System.out.println("battery: " +
		 * batteryTypeSim(other, threshold[15]));
		 * System.out.println("warranty: " + warrantySim(other, threshold[16]));
		 * System.out.println("price: " + priceSim(other, threshold[17]));
		 */
		// +
		// +
		// + graphicsCardSim(other, threshold[10])
		// + osSim(other, threshold[11])
		// + cpuTypeSim(other, threshold[12])
		// + cpuSpeedSim(other, threshold[13])
		// + cpuCacheSim(other, threshold[14])
		// + batteryTypeSim(other, threshold[15])
		// + warrantySim(other, threshold[16])
		// + priceSim(other, threshold[17]);

		return sim;
	}
}
