package mod.drf.recipie;

import java.util.List;

public interface IOriginalMenu {

	public abstract OriginalMenu.OriginalMenuKind getKind();
	public List<OriginalMenu> getMenu();
}
