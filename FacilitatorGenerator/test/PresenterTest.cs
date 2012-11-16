using System.Collections.Generic;
using System.Linq;
using System.Text;
using Moq;
using NUnit.Framework;

namespace FacilitatorGenerator.test
{
    internal class PresenterTest
    {
        private Presenter presenter;
        private Mock<IView> view;
        private Generator generator;

        [SetUp]
        public void SetUp()
        {
            view = new Mock<IView>();
            generator = new Generator();
            view.Object.SetPresenter(presenter);         
            presenter = new Presenter(view.Object, generator);
        }

        [Test]
        public void should_add_name_to_name_list_when_click_addperson_button()
        {
            view.Setup(o => o.GetPersonName()).Returns("not care");
            presenter.OnAddPersonButtonClick();
            view.Verify(o => o.AddPersonToNameList("not care"),Times.Once());
            view.Verify(o => o.ResetPersonName(),Times.Once());
        }

        [Test]
        public void should_not_add_empty_name_to_name_list()
        {
            view.Setup(o => o.GetPersonName()).Returns("");
            presenter.OnAddPersonButtonClick();
            view.Verify(o => o.AddPersonToNameList(It.IsAny<string>()), Times.Never());
            view.Verify(o => o.ResetPersonName(), Times.Once());
        }

        [Test]
        public void should_move_person_from_namelist_to_selectedNameList_when_click_right_arrow()
        {
            const string selectedName = "selected";
            view.Setup(o => o.GetSelectedPerson()).Returns(selectedName);
            presenter.OnSelectPersonButtonClick();
            view.Verify(o=>o.AddPersonToSelectedNameList(selectedName),Times.Once());
            view.Verify(o => o.RemovePersonFromNameList(selectedName), Times.Once());
            Assert.AreEqual(1,generator.Attendance());
        }
    }
}
