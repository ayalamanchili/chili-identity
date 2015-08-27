package info.yalamanchili.security.gwt.role;

import info.yalamanchili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.gwt.composite.SelectComposite;
import info.yalamanchili.gwt.composite.TreePanelComposite;
import info.yalamanchili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.security.gwt.AdminService.AdminServiceAsync;
import info.yalamanchili.security.gwt.YRole;
import info.yalamanchili.security.gwt.YUser;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class SelectRolePanel extends SelectComposite<YRole> {
	public SelectRolePanel(String title, TreePanelComposite parent,
			Map<Long, String> available, Set<Long> selected) {
		super(title, parent, available, selected);
	}

	@Override
	protected void initListBox() {
		String[] columns = { "rolename", };
		AdminServiceAsync.instance().getListBoxValuesRole(columns,
				new ALAsyncCallback<Map<Long, String>>() {

					@Override
					public void onResponse(Map<Long, String> arg0) {
						populateListBox(arg0);

					}
				});
	}

	@Override
	public void getSelectedEntity(Long id) {

	}

	public void setSelectedEntity(YRole entity) {
		if (entity.getRoleId() != null)
			listBox.setItemSelected(valueIndex.get(entity.getRoleId()), true);
	}

	@Override
	public void onAdd() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void addListeners() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void addWidgets() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void configure() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onAddAll(TreePanelComposite parent, List<Long> ids) {
		if (parent.getEntity() instanceof YUser) {
			AdminServiceAsync.instance().addRoles((YUser) parent.getEntity(),
					ids, new ALAsyncCallback<Void>() {

						@Override
						public void onResponse(Void arg0) {
							new ResponseStatusWidget()
									.show("roles added to User");

						}

					});
		}
		if (parent.getEntity() instanceof YRole) {
			AdminServiceAsync.instance().addRoles((YRole) parent.getEntity(),
					ids, new ALAsyncCallback<Void>() {

						@Override
						public void onResponse(Void arg0) {
							new ResponseStatusWidget()
									.show("roles added to Role");

						}

					});
		}

	}

	@Override
	public void onRemoveAll(TreePanelComposite parent, List<Long> ids) {
		if (parent.getEntity() instanceof YUser) {
			AdminServiceAsync.instance().removeRoles(
					(YUser) parent.getEntity(), ids,
					new ALAsyncCallback<Void>() {

						@Override
						public void onResponse(Void arg0) {
							new ResponseStatusWidget()
									.show("roles removed from user");

						}

					});
		}
		if (parent.getEntity() instanceof YRole) {
			AdminServiceAsync.instance().removeRoles(
					(YRole) parent.getEntity(), ids,
					new ALAsyncCallback<Void>() {

						@Override
						public void onResponse(Void arg0) {
							new ResponseStatusWidget()
									.show("roles removed from role");

						}

					});
		}

	}
}
