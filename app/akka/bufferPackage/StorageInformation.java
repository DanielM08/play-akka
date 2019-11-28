package akka.bufferPackage;

import java.util.List;
import java.util.Vector;

public class StorageInformation {
	private final List<BufferRow> storage;

	public StorageInformation() {
		storage = new Vector<BufferRow>();
	}

	public void setRow(BufferRow row) {
		storage.add(row);
	}

	public List<BufferRow> getData() {
		return storage;
	}
	
	public BufferRow getRow(int rowPos) {
		if ((rowPos >= 0) && (rowPos < storage.size())) {
			return storage.get(rowPos);
		}
		return null;
	}

	public int getSize() {
		return storage.size();
	}
}
