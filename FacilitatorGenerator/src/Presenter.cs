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
            if (string.IsNullOrEmpty(selectedPerson)) return;
            view.AddPersonToSelectedNameList(selectedPerson);
            view.RemovePersonFromNameList(selectedPerson);
            generator.AddPerson(selectedPerson);
        }

        public void OnUnSelectPersonButtonClick()
        {
            var selectedPerson = view.GetUnSelectedPerson();
            if (string.IsNullOrEmpty(selectedPerson)) return;
            view.RemovePersonFromSelectedNameList(selectedPerson);
            view.AddPersonToNameList(selectedPerson);
            generator.RemovePerson(selectedPerson);

        }

        public void OnGenerateButtonClick()
        {
            int selectedPersonCount = view.GetSelectedPersonCount();
            generator.SetRandomGenerator(new RandomNumberGenerator(selectedPersonCount));
            generator.Run();
            view.ShowPresenter(generator.Presenter);
            view.ShowLunchOrder(generator.LunchOrder);
        }
    }
}