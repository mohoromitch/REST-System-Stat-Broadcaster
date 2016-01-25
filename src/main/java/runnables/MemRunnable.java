package runnables;

import org.hyperic.sigar.Mem;
import org.hyperic.sigar.SigarException;
import pollers.MemPoller;

/**
 * Created by mitchellmohorovich on 2016-01-24.
 * A runnable subclass that polls for memory metrics.
 */
public class MemRunnable extends MetricRunnable {

	private MemPoller memPoller;

	public MemRunnable(MemPoller memPoller) {
		super();
		this.memPoller = memPoller;
	}

	@Override
	protected void pollAllMetrics() {
		pollMem();
	}

	private void pollMem() {
		try {
			this.memPoller.setMem(this.sigar.getMem());
		} catch (SigarException e) {
			e.printStackTrace();
		}
	}

}
