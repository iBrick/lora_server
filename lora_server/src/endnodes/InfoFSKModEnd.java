package endnodes;

public class InfoFSKModEnd implements Info{
	public String time;
	public double tmst;
	public int freq;
	public int chan;
	public int rfch;
	public int stat;
	public String modu;
	public int datr_fsk;
	public int rssi;
	public int size;
	public String data;
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public double getTmst() {
		return tmst;
	}
	public void setTmst(int tmst) {
		this.tmst = tmst;
	}
	public int getFreq() {
		return freq;
	}
	public void setFreq(int freq) {
		this.freq = freq;
	}
	public int getChan() {
		return chan;
	}
	public void setChan(int chan) {
		this.chan = chan;
	}
	public int getRfch() {
		return rfch;
	}
	public void setRfch(int rfch) {
		this.rfch = rfch;
	}
	public int getStat() {
		return stat;
	}
	public void setStat(int stat) {
		this.stat = stat;
	}
	public String getModu() {
		return modu;
	}
	public void setModu(String modu) {
		this.modu = modu;
	}
	
	public int getDatr_fsk() {
		return datr_fsk;
	}
	public void setDatr_fsk(int datr_fsk) {
		this.datr_fsk = datr_fsk;
	}
	public int getRssi() {
		return rssi;
	}
	public void setRssi(int rssi) {
		this.rssi = rssi;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	@Override
	public void saveData() {
		// TODO Auto-generated method stub
		System.out.println("FSK");
	}
	
}