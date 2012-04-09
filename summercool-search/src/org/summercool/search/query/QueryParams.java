package org.summercool.search.query;

public class QueryParams {

	private int position = 0;

	private StringBuilder sb = new StringBuilder();

	public void addANDConditionParam(String param) {
		position = position + 1;
		if (position == 1) {
			sb.append(param);
		} else {
			sb.append(" AND " + param);
		}
	}

	public void addORConditionParam(String param) {
		position = position + 1;
		if (position == 1) {
			sb.append(param);
		} else {
			sb.append(" OR " + "(" + param + ")");
		}
	}

	@Override
	public String toString() {
		return sb.toString();
	}

}
