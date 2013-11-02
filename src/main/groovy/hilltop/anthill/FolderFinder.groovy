package hilltop.anthill

import com.urbancode.anthill3.domain.folder.*

@Mixin(FeedbackHelper)
class FolderFinder {
  def FolderFinder(Closure handlers) {
    if (handlers) init_feedback(handlers)
  }

  def all(inactive) {
    inactive ?
      FolderFactory.getInstance().restoreAll() :
      FolderFactory.getInstance().restoreAllActive()
  }

  def one(name) {
    def folder = FolderFactory.getInstance().restoreForName(name)
    if (!folder) error "No such folder <$name>"
    folder
  }
}
