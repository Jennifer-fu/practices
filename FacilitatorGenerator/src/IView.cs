using System.Collections.Generic;

namespace FacilitatorGenerator
{
    public interface IView
    {
        string GetPersonName();
        void ResetPersonName();
        void SetPresenter(Presenter presenter);
        string GetSelectedPerson();
        void AddPersonToNameList(string name);
        void AddPersonToSelectedNameList(string name);
        void RemovePersonFromNameList(string name);
        void RemovePersonFromSelectedNameList(string name);
        IList<string> GetSelectedPersonList();
        void ShowPresenter(string name);
        void ShowLunchOrder(string lunchOrder);
        string GetUnSelectedPerson();
    }
}