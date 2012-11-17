using System;
using System.Collections.Generic;
using System.Windows.Forms;

namespace FacilitatorGenerator
{
    public partial class MainForm : Form,IView
    {
        private Presenter logicPresenter;
        public MainForm()
        {
            InitializeComponent();
        }

        private void AddPerson_Button_Click(object sender, EventArgs e)
        {
            logicPresenter.OnAddPersonButtonClick();
        }

        private void generateButton_Click(object sender, EventArgs e)
        {
            logicPresenter.OnGenerateButtonClick();
        }

        private void selectButton_Click(object sender, EventArgs e)
        {
            logicPresenter.OnSelectPersonButtonClick();
        }

        private void unselectButton_Click(object sender, EventArgs e)
        {
            logicPresenter.OnUnSelectPersonButtonClick();
        }

        public void AddPersonToNameList(string name)
        {
            nameList.Items.Add(name);
        }

        public string GetPersonName()
        {
            return personNameTextBox.Text;
        }

        public void ResetPersonName()
        {
            personNameTextBox.Text = "";
        }

        public void SetPresenter(Presenter presenter)
        {
            logicPresenter = presenter;
        }

        public string GetSelectedPerson()
        {
            return (string) nameList.SelectedItem;
        }

        public void AddPersonToSelectedNameList(string name)
        {
            selectedNameList.Items.Add(name);
        }

        public void RemovePersonFromNameList(string name)
        {
            nameList.Items.Remove(name);
        }

        public void RemovePersonFromSelectedNameList(string name)
        {
            selectedNameList.Items.Remove(name);
        }

        public IList<string> GetSelectedPersonList()
        {
            return selectedNameList.Items as IList<string>;
        }

        public void ShowPresenter(string name)
        {
            presenter.Text = name;
        }

        public void ShowLunchOrder(string name)
        {
            lunchOrder.Text = name;
        }

        public string GetUnSelectedPerson()
        {
            return (string)selectedNameList.SelectedItem;
        }
    }
}