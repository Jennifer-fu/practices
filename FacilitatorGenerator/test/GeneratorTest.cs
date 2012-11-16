using Moq;
using NUnit.Framework;

namespace FacilitatorGenerator.test
{
    public class GeneratorTest
    {
        private Generator generator;
        private Mock<RandomNumberGenerator> randomNumberGenerator;

        [SetUp]
        public void SetUp()
        {
            randomNumberGenerator = new Mock<RandomNumberGenerator>(3);
            int index = 0;
            randomNumberGenerator.Setup(o => o.Next()).Returns(() => index).Callback(() => index++);
            generator = new Generator(randomNumberGenerator.Object);
        }

        [Test]
        public void should_return_first_two_persons_when_generate_facilitators()
        {
            generator.AddPerson("A");
            generator.AddPerson("B");
            generator.AddPerson("C");
            generator.Run();
            Assert.AreEqual("A",generator.Presenter);
            Assert.AreEqual("B",generator.LunchOrder);
        }

        [Test]
        [ExpectedException(typeof(PersonNotEnoughException))]
        public void should_throw_exception_when_persons_are_less_than_two()
        {
            generator.AddPerson("A");
            generator.Run();
        }
    }
}