package hd.entity.bestbuy;

public class Laptop {

	// Attributes
	private String name;
	private String model;
	private String sku;
	private String reviewPoint;

	// Specification Attribute
	private String warrantyPart;
	private String warrantyLabor;
	private String height;
	private String width;
	private String depth;
	private String processorBrand;
	private String processorGeneration;
	private String processorSpeed;
	private String batteryType;
	private String displayType;
	private String screenSize;
	private String ram;
	private String ramExpandableTo;
	private String ramType;
	private String hardDriveSize;
	private String opticalDrive;
	private String opticalDriveSpeed;
	private String directDicsLabeling;
	private String digitalMediaReader;
	private String graphics;
	private String videoMemory;
	private String tvTuner;
	private String mpeg;
	private String buildInWebcam;
	private String modem;
	private String networking;
	private String wireless;
	private String bluetooth;
	private String sVideoOutput;
	private String audio;
	private String speakers;
	private String pcmcia;
	private String usbPorts;
	private String ieee1394Ports;
	private String parallelPorts;
	private String gamePorts;
	private String weight;
	private String batteryLife;
	private String pointingDevice;
	private String blurayPlayer;
	private String operatingSystem;
	private String systemVersion;
	private String includedSoftware;
	private String energyStarQuanlified;
	private String bestbuyPCApp;
	private String graphicsChip;
	private String blacklitKeyboard;
	private String driveCapacity;
	private String graphicsCard;
	private String wirelessDisplay;
	private String upc;

	// Constructor without parameter
	public Laptop() {
	}

	// Constructor with all fields
	/**
	 * @param name
	 * @param model
	 * @param sKU
	 * @param reviewPoint
	 * @param warrantyPart
	 * @param warrantyLabor
	 * @param height
	 * @param width
	 * @param depth
	 * @param processorBrand
	 * @param processorGeneration
	 * @param processorSpeed
	 * @param batteryType
	 * @param displayType
	 * @param screenSize
	 * @param ram
	 * @param ramExpandableTo
	 * @param ramType
	 * @param hardDriveSize
	 * @param opticalDrive
	 * @param opticalDriveSpeed
	 * @param directDicsLabeling
	 * @param digitalMediaReader
	 * @param graphics
	 * @param videoMemory
	 * @param tvTuner
	 * @param mpeg
	 * @param buildInWebcam
	 * @param modem
	 * @param networking
	 * @param wireless
	 * @param bluetooth
	 * @param sVideoOutput
	 * @param audio
	 * @param speakers
	 * @param pcmcia
	 * @param usbPorts
	 * @param ieee1394Ports
	 * @param parallelPorts
	 * @param gamePorts
	 * @param weight
	 * @param batteryLife
	 * @param pointingDevice
	 * @param blurayPlayer
	 * @param operatingSystem
	 * @param systemVersion
	 * @param includedSoftware
	 * @param energyStarQuanlified
	 * @param bestbuyPCApp
	 * @param graphicsChip
	 * @param blacklitKeyboard
	 * @param driveCapacity
	 * @param graphicsCard
	 * @param wirelessDisplay
	 * @param upc
	 */
	public Laptop(String name, String model, String sKU, String reviewPoint,
			String warrantyPart, String warrantyLabor, String height,
			String width, String depth, String processorBrand,
			String processorGeneration, String processorSpeed,
			String batteryType, String displayType, String screenSize,
			String ram, String ramExpandableTo, String ramType,
			String hardDriveSize, String opticalDrive,
			String opticalDriveSpeed, String directDicsLabeling,
			String digitalMediaReader, String graphics, String videoMemory,
			String tvTuner, String mpeg, String buildInWebcam, String modem,
			String networking, String wireless, String bluetooth,
			String sVideoOutput, String audio, String speakers, String pcmcia,
			String usbPorts, String ieee1394Ports, String parallelPorts,
			String gamePorts, String weight, String batteryLife,
			String pointingDevice, String blurayPlayer, String operatingSystem,
			String systemVersion, String includedSoftware,
			String energyStarQuanlified, String bestbuyPCApp,
			String graphicsChip, String blacklitKeyboard, String driveCapacity,
			String graphicsCard, String wirelessDisplay, String upc) {
		super();
		this.name = name;
		this.model = model;
		this.sku = sKU;
		this.reviewPoint = reviewPoint;
		this.warrantyPart = warrantyPart;
		this.warrantyLabor = warrantyLabor;
		this.height = height;
		this.width = width;
		this.depth = depth;
		this.processorBrand = processorBrand;
		this.processorGeneration = processorGeneration;
		this.processorSpeed = processorSpeed;
		this.batteryType = batteryType;
		this.displayType = displayType;
		this.screenSize = screenSize;
		this.ram = ram;
		this.ramExpandableTo = ramExpandableTo;
		this.ramType = ramType;
		this.hardDriveSize = hardDriveSize;
		this.opticalDrive = opticalDrive;
		this.opticalDriveSpeed = opticalDriveSpeed;
		this.directDicsLabeling = directDicsLabeling;
		this.digitalMediaReader = digitalMediaReader;
		this.graphics = graphics;
		this.videoMemory = videoMemory;
		this.tvTuner = tvTuner;
		this.mpeg = mpeg;
		this.buildInWebcam = buildInWebcam;
		this.modem = modem;
		this.networking = networking;
		this.wireless = wireless;
		this.bluetooth = bluetooth;
		this.sVideoOutput = sVideoOutput;
		this.audio = audio;
		this.speakers = speakers;
		this.pcmcia = pcmcia;
		this.usbPorts = usbPorts;
		this.ieee1394Ports = ieee1394Ports;
		this.parallelPorts = parallelPorts;
		this.gamePorts = gamePorts;
		this.weight = weight;
		this.batteryLife = batteryLife;
		this.pointingDevice = pointingDevice;
		this.blurayPlayer = blurayPlayer;
		this.operatingSystem = operatingSystem;
		this.systemVersion = systemVersion;
		this.includedSoftware = includedSoftware;
		this.energyStarQuanlified = energyStarQuanlified;
		this.bestbuyPCApp = bestbuyPCApp;
		this.graphicsChip = graphicsChip;
		this.blacklitKeyboard = blacklitKeyboard;
		this.driveCapacity = driveCapacity;
		this.graphicsCard = graphicsCard;
		this.wirelessDisplay = wirelessDisplay;
		this.upc = upc;
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
	 * @return the sKU
	 */
	public String getSku() {
		return sku;
	}

	/**
	 * @param sKU
	 *            the sKU to set
	 */
	public void setSKU(String sKU) {
		this.sku = sKU;
	}

	/**
	 * @return the reviewPoint
	 */
	public String getReviewPoint() {
		return reviewPoint;
	}

	/**
	 * @param reviewPoint
	 *            the reviewPoint to set
	 */
	public void setReviewPoint(String reviewPoint) {
		this.reviewPoint = reviewPoint;
	}

	/**
	 * @return the warrantyPart
	 */
	public String getWarrantyPart() {
		return warrantyPart;
	}

	/**
	 * @param warrantyPart
	 *            the warrantyPart to set
	 */
	public void setWarrantyPart(String warrantyPart) {
		this.warrantyPart = warrantyPart;
	}

	/**
	 * @return the warrantyLabor
	 */
	public String getWarrantyLabor() {
		return warrantyLabor;
	}

	/**
	 * @param warrantyLabor
	 *            the warrantyLabor to set
	 */
	public void setWarrantyLabor(String warrantyLabor) {
		this.warrantyLabor = warrantyLabor;
	}

	/**
	 * @return the height
	 */
	public String getHeight() {
		return height;
	}

	/**
	 * @param height
	 *            the height to set
	 */
	public void setHeight(String height) {
		this.height = height;
	}

	/**
	 * @return the width
	 */
	public String getWidth() {
		return width;
	}

	/**
	 * @param width
	 *            the width to set
	 */
	public void setWidth(String width) {
		this.width = width;
	}

	/**
	 * @return the depth
	 */
	public String getDepth() {
		return depth;
	}

	/**
	 * @param depth
	 *            the depth to set
	 */
	public void setDepth(String depth) {
		this.depth = depth;
	}

	/**
	 * @return the processorBrand
	 */
	public String getProcessorBrand() {
		return processorBrand;
	}

	/**
	 * @param processorBrand
	 *            the processorBrand to set
	 */
	public void setProcessorBrand(String processorBrand) {
		this.processorBrand = processorBrand;
	}

	/**
	 * @return the processorGeneration
	 */
	public String getProcessorGeneration() {
		return processorGeneration;
	}

	/**
	 * @param processorGeneration
	 *            the processorGeneration to set
	 */
	public void setProcessorGeneration(String processorGeneration) {
		this.processorGeneration = processorGeneration;
	}

	/**
	 * @return the processorSpeed
	 */
	public String getProcessorSpeed() {
		return processorSpeed;
	}

	/**
	 * @param processorSpeed
	 *            the processorSpeed to set
	 */
	public void setProcessorSpeed(String processorSpeed) {
		this.processorSpeed = processorSpeed;
	}

	/**
	 * @return the batteryType
	 */
	public String getBatteryType() {
		return batteryType;
	}

	/**
	 * @param batteryType
	 *            the batteryType to set
	 */
	public void setBatteryType(String batteryType) {
		this.batteryType = batteryType;
	}

	/**
	 * @return the displayType
	 */
	public String getDisplayType() {
		return displayType;
	}

	/**
	 * @param displayType
	 *            the displayType to set
	 */
	public void setDisplayType(String displayType) {
		this.displayType = displayType;
	}

	/**
	 * @return the screenSize
	 */
	public String getScreenSize() {
		return screenSize;
	}

	/**
	 * @param screenSize
	 *            the screenSize to set
	 */
	public void setScreenSize(String screenSize) {
		this.screenSize = screenSize;
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
	 * @return the ramExpandableTo
	 */
	public String getRamExpandableTo() {
		return ramExpandableTo;
	}

	/**
	 * @param ramExpandableTo
	 *            the ramExpandableTo to set
	 */
	public void setRamExpandableTo(String ramExpandableTo) {
		this.ramExpandableTo = ramExpandableTo;
	}

	/**
	 * @return the ramType
	 */
	public String getRamType() {
		return ramType;
	}

	/**
	 * @param ramType
	 *            the ramType to set
	 */
	public void setRamType(String ramType) {
		this.ramType = ramType;
	}

	/**
	 * @return the hardDriveSize
	 */
	public String getHardDriveSize() {
		return hardDriveSize;
	}

	/**
	 * @param hardDriveSize
	 *            the hardDriveSize to set
	 */
	public void setHardDriveSize(String hardDriveSize) {
		this.hardDriveSize = hardDriveSize;
	}

	/**
	 * @return the opticalDrive
	 */
	public String getOpticalDrive() {
		return opticalDrive;
	}

	/**
	 * @param opticalDrive
	 *            the opticalDrive to set
	 */
	public void setOpticalDrive(String opticalDrive) {
		this.opticalDrive = opticalDrive;
	}

	/**
	 * @return the opticalDriveSpeed
	 */
	public String getOpticalDriveSpeed() {
		return opticalDriveSpeed;
	}

	/**
	 * @param opticalDriveSpeed
	 *            the opticalDriveSpeed to set
	 */
	public void setOpticalDriveSpeed(String opticalDriveSpeed) {
		this.opticalDriveSpeed = opticalDriveSpeed;
	}

	/**
	 * @return the directDicsLabeling
	 */
	public String getDirectDicsLabeling() {
		return directDicsLabeling;
	}

	/**
	 * @param directDicsLabeling
	 *            the directDicsLabeling to set
	 */
	public void setDirectDicsLabeling(String directDicsLabeling) {
		this.directDicsLabeling = directDicsLabeling;
	}

	/**
	 * @return the digitalMediaReader
	 */
	public String getDigitalMediaReader() {
		return digitalMediaReader;
	}

	/**
	 * @param digitalMediaReader
	 *            the digitalMediaReader to set
	 */
	public void setDigitalMediaReader(String digitalMediaReader) {
		this.digitalMediaReader = digitalMediaReader;
	}

	/**
	 * @return the graphics
	 */
	public String getGraphics() {
		return graphics;
	}

	/**
	 * @param graphics
	 *            the graphics to set
	 */
	public void setGraphics(String graphics) {
		this.graphics = graphics;
	}

	/**
	 * @return the videoMemory
	 */
	public String getVideoMemory() {
		return videoMemory;
	}

	/**
	 * @param videoMemory
	 *            the videoMemory to set
	 */
	public void setVideoMemory(String videoMemory) {
		this.videoMemory = videoMemory;
	}

	/**
	 * @return the tvTuner
	 */
	public String getTvTuner() {
		return tvTuner;
	}

	/**
	 * @param tvTuner
	 *            the tvTuner to set
	 */
	public void setTvTuner(String tvTuner) {
		this.tvTuner = tvTuner;
	}

	/**
	 * @return the mpeg
	 */
	public String getMpeg() {
		return mpeg;
	}

	/**
	 * @param mpeg
	 *            the mpeg to set
	 */
	public void setMpeg(String mpeg) {
		this.mpeg = mpeg;
	}

	/**
	 * @return the buildInWebcam
	 */
	public String getBuildInWebcam() {
		return buildInWebcam;
	}

	/**
	 * @param buildInWebcam
	 *            the buildInWebcam to set
	 */
	public void setBuildInWebcam(String buildInWebcam) {
		this.buildInWebcam = buildInWebcam;
	}

	/**
	 * @return the modem
	 */
	public String getModem() {
		return modem;
	}

	/**
	 * @param modem
	 *            the modem to set
	 */
	public void setModem(String modem) {
		this.modem = modem;
	}

	/**
	 * @return the networking
	 */
	public String getNetworking() {
		return networking;
	}

	/**
	 * @param networking
	 *            the networking to set
	 */
	public void setNetworking(String networking) {
		this.networking = networking;
	}

	/**
	 * @return the wireless
	 */
	public String getWireless() {
		return wireless;
	}

	/**
	 * @param wireless
	 *            the wireless to set
	 */
	public void setWireless(String wireless) {
		this.wireless = wireless;
	}

	/**
	 * @return the bluetooth
	 */
	public String getBluetooth() {
		return bluetooth;
	}

	/**
	 * @param bluetooth
	 *            the bluetooth to set
	 */
	public void setBluetooth(String bluetooth) {
		this.bluetooth = bluetooth;
	}

	/**
	 * @return the sVideoOutput
	 */
	public String getsVideoOutput() {
		return sVideoOutput;
	}

	/**
	 * @param sVideoOutput
	 *            the sVideoOutput to set
	 */
	public void setsVideoOutput(String sVideoOutput) {
		this.sVideoOutput = sVideoOutput;
	}

	/**
	 * @return the audio
	 */
	public String getAudio() {
		return audio;
	}

	/**
	 * @param audio
	 *            the audio to set
	 */
	public void setAudio(String audio) {
		this.audio = audio;
	}

	/**
	 * @return the speakers
	 */
	public String getSpeakers() {
		return speakers;
	}

	/**
	 * @param speakers
	 *            the speakers to set
	 */
	public void setSpeakers(String speakers) {
		this.speakers = speakers;
	}

	/**
	 * @return the pcmcia
	 */
	public String getPcmcia() {
		return pcmcia;
	}

	/**
	 * @param pcmcia
	 *            the pcmcia to set
	 */
	public void setPcmcia(String pcmcia) {
		this.pcmcia = pcmcia;
	}

	/**
	 * @return the usbPorts
	 */
	public String getUsbPorts() {
		return usbPorts;
	}

	/**
	 * @param usbPorts
	 *            the usbPorts to set
	 */
	public void setUsbPorts(String usbPorts) {
		this.usbPorts = usbPorts;
	}

	/**
	 * @return the ieee1394Ports
	 */
	public String getIeee1394Ports() {
		return ieee1394Ports;
	}

	/**
	 * @param ieee1394Ports
	 *            the ieee1394Ports to set
	 */
	public void setIeee1394Ports(String ieee1394Ports) {
		this.ieee1394Ports = ieee1394Ports;
	}

	/**
	 * @return the parallelPorts
	 */
	public String getParallelPorts() {
		return parallelPorts;
	}

	/**
	 * @param parallelPorts
	 *            the parallelPorts to set
	 */
	public void setParallelPorts(String parallelPorts) {
		this.parallelPorts = parallelPorts;
	}

	/**
	 * @return the gamePorts
	 */
	public String getGamePorts() {
		return gamePorts;
	}

	/**
	 * @param gamePorts
	 *            the gamePorts to set
	 */
	public void setGamePorts(String gamePorts) {
		this.gamePorts = gamePorts;
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
	 * @return the batteryLife
	 */
	public String getBatteryLife() {
		return batteryLife;
	}

	/**
	 * @param batteryLife
	 *            the batteryLife to set
	 */
	public void setBatteryLife(String batteryLife) {
		this.batteryLife = batteryLife;
	}

	/**
	 * @return the pointingDevice
	 */
	public String getPointingDevice() {
		return pointingDevice;
	}

	/**
	 * @param pointingDevice
	 *            the pointingDevice to set
	 */
	public void setPointingDevice(String pointingDevice) {
		this.pointingDevice = pointingDevice;
	}

	/**
	 * @return the blurayPlayer
	 */
	public String getBlurayPlayer() {
		return blurayPlayer;
	}

	/**
	 * @param blurayPlayer
	 *            the blurayPlayer to set
	 */
	public void setBlurayPlayer(String blurayPlayer) {
		this.blurayPlayer = blurayPlayer;
	}

	/**
	 * @return the operatingSystem
	 */
	public String getOperatingSystem() {
		return operatingSystem;
	}

	/**
	 * @param operatingSystem
	 *            the operatingSystem to set
	 */
	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	/**
	 * @return the systemVersion
	 */
	public String getSystemVersion() {
		return systemVersion;
	}

	/**
	 * @param systemVersion
	 *            the systemVersion to set
	 */
	public void setSystemVersion(String systemVersion) {
		this.systemVersion = systemVersion;
	}

	/**
	 * @return the includedSoftware
	 */
	public String getIncludedSoftware() {
		return includedSoftware;
	}

	/**
	 * @param includedSoftware
	 *            the includedSoftware to set
	 */
	public void setIncludedSoftware(String includedSoftware) {
		this.includedSoftware = includedSoftware;
	}

	/**
	 * @return the energyStarQuanlified
	 */
	public String getEnergyStarQuanlified() {
		return energyStarQuanlified;
	}

	/**
	 * @param energyStarQuanlified
	 *            the energyStarQuanlified to set
	 */
	public void setEnergyStarQuanlified(String energyStarQuanlified) {
		this.energyStarQuanlified = energyStarQuanlified;
	}

	/**
	 * @return the bestbuyPCApp
	 */
	public String getBestbuyPCApp() {
		return bestbuyPCApp;
	}

	/**
	 * @param bestbuyPCApp
	 *            the bestbuyPCApp to set
	 */
	public void setBestbuyPCApp(String bestbuyPCApp) {
		this.bestbuyPCApp = bestbuyPCApp;
	}

	/**
	 * @return the graphicsChip
	 */
	public String getGraphicsChip() {
		return graphicsChip;
	}

	/**
	 * @param graphicsChip
	 *            the graphicsChip to set
	 */
	public void setGraphicsChip(String graphicsChip) {
		this.graphicsChip = graphicsChip;
	}

	/**
	 * @return the blacklitKeyboard
	 */
	public String getBlacklitKeyboard() {
		return blacklitKeyboard;
	}

	/**
	 * @param blacklitKeyboard
	 *            the blacklitKeyboard to set
	 */
	public void setBlacklitKeyboard(String blacklitKeyboard) {
		this.blacklitKeyboard = blacklitKeyboard;
	}

	/**
	 * @return the driveCapacity
	 */
	public String getDriveCapacity() {
		return driveCapacity;
	}

	/**
	 * @param driveCapacity
	 *            the driveCapacity to set
	 */
	public void setDriveCapacity(String driveCapacity) {
		this.driveCapacity = driveCapacity;
	}

	/**
	 * @return the graphicsCard
	 */
	public String getGraphicsCard() {
		return graphicsCard;
	}

	/**
	 * @param graphicsCard
	 *            the graphicsCard to set
	 */
	public void setGraphicsCard(String graphicsCard) {
		this.graphicsCard = graphicsCard;
	}

	/**
	 * @return the wirelessDisplay
	 */
	public String getWirelessDisplay() {
		return wirelessDisplay;
	}

	/**
	 * @param wirelessDisplay
	 *            the wirelessDisplay to set
	 */
	public void setWirelessDisplay(String wirelessDisplay) {
		this.wirelessDisplay = wirelessDisplay;
	}

	/**
	 * @return the upc
	 */
	public String getUpc() {
		return upc;
	}

	/**
	 * @param upc
	 *            the upc to set
	 */
	public void setUpc(String upc) {
		this.upc = upc;
	}
}
