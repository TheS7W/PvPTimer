package lemon42.PvPTimer;
class CheckTask implements Runnable {
	private PvPTimer plugin;
	
	public CheckTask(PvPTimer p) {
		this.plugin = p;
	}
	
	@Override
	public void run() {
		synchronized(plugin.times) {
			if(!plugin.times.isEmpty())
				for(String p : plugin.times.keySet())
					try {
						plugin.checkPlayer(plugin.getServer().getOfflinePlayer(p));
					} catch (Exception e) {} //Exception should never happen, but... better safe than sorry :)
		}
	}
}
