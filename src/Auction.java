import java.util.ArrayList;
import java.util.Date;

public class Auction {

	private ArrayList<Bid> bids = new ArrayList<Bid>();
	private Artwork art;
	private User owner;
	private Integer maxBids;
	private float reserve;
	private long timeCreated;
	private boolean completed = false;

	Date date = new Date();

	public Auction(Artwork art, Integer maxBids, float reserve, User owner) {

		this.art = art;
		this.maxBids = maxBids;
		this.reserve = reserve;
		this.owner = owner;
		this.timeCreated = date.getTime();
	}

	public void setBid(Bid bid) {
		bids.add(bid);
	}

	public Bid getBid(Integer i) {
		return bids.get(i);
	}

	public float getReserve() {
		return reserve;
	}

	public long getTime() {
		return timeCreated;
	}

	public Artwork getArtwork() {
		return art;
	}

	public User getUser() {
		return owner;
	}

	public boolean checkCompleted() {
		return completed;
	}
}
