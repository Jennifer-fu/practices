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
    }
}