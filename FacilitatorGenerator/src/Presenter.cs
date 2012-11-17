using System;
using FacilitatorGenerator.test;

namespace FacilitatorGenerator
{
    public class Presenter
    {
        private readonly IView view;
        private readonly Generator generator;

        public Presenter(IView view, Generator generator)
        {
            this.view = view;
            this.generator = generator;
        }

        public void OnAddPersonButtonClick()
        {
            var personName = view.GetPersonName();
            if (!String.IsNullOrEmpty(personName))
                view.AddPersonToNameList(personName);
            view.ResetPersonName();
        }

        public void OnSelectPersonButtonClick()
        {
            var selectedPerson = view.GetSelectedPerson();
            view.AddPersonToSelectedNameList(selectedPerson);
            view.RemovePersonFromNameList(selectedPerson);
            generator.AddPerson(selectedPerson);
        
        }

        public void OnUnSelectPersonButtonClick()
        {
            var selectedPerson = view.GetSelectedPerson();
            view.RemovePersonFromSelectedNameList(selectedPerson);
            view.AddPersonToNameList(selectedPerson);
            generator.RemovePerson(selectedPerson);

        }

        public void OnGenerateButtonClick()
        {
            var selectedPersonList = view.GetSelectedPersonList();
            generator.SetRandomGenerator(new RandomNumberGenerator(selectedPersonList.Count));
            generator.Run();
            view.ShowPresenter(generator.Presenter);
            view.ShowLunchOrder(generator.LunchOrder);
        }
    }
}