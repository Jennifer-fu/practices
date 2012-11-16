namespace FacilitatorGenerator
{
    public interface IView
    {
        void AddPersonToNameList(string name);
        string GetPersonName();
        void ResetPersonName();
        void SetPresenter(Presenter presenter);
        string GetSelectedPerson();
        void AddPersonToSelectedNameList(string name);
        void RemovePersonFromNameList(string name);
    }
}