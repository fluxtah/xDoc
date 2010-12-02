/**
 * <copyright>
 * </copyright>
 *
 */
package images;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see images.ImagesPackage
 * @generated
 */
public interface ImagesFactory extends EFactory
{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ImagesFactory eINSTANCE = images.impl.ImagesFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Image Proxy</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Image Proxy</em>'.
	 * @generated
	 */
	ImageProxy createImageProxy();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ImagesPackage getImagesPackage();

} //ImagesFactory